package ca.jrvs.apps.grep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepLambdaImp implements JavaGrepLambda {
    private static final Logger logger = LoggerFactory.getLogger(JavaGrep.class);
    private String regex;
    private String rootPath;
    private String outFile;

    @Override
    public void process() {
        logger.info("Processing Files for lines");
        List<String> matchedLines = listFiles(rootPath)
                .flatMap(this::readLines)
                .filter(this::containsPattern)
                .collect(Collectors.toList());

        logger.info("Writing lines to {}", outFile);
        writeToFile(matchedLines);
    }

    @Override
    public Stream<File> listFiles(String rootDir) {
        try {
            return Files.walk(Paths.get(rootDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Stream<String> readLines(File inputFile) {
        try {
            return Files.lines(inputFile.toPath());
        } catch (IOException e) {
            logger.error("Error trying to read from file {}", inputFile, e);
            return Stream.empty();
        }
    }

    @Override
    public boolean containsPattern(String line) {
        Pattern pattern = Pattern.compile(this.regex);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            logger.debug("Pattern {} is in Line {}", this.regex, line);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void writeToFile(List<String> lines) {
        try {
            File file = new File(this.outFile);
            file.getParentFile().mkdirs();

            logger.debug("Creating new try with resources statement for writing to output file");
            try (FileWriter fileWriter = new FileWriter(this.outFile)) {
                int index = 0;

                while (index < lines.size()) {
                    String line = lines.get(index);
                    if (line != null) {
                        logger.debug("Adding {} to {}", line, this.outFile);
                        fileWriter.write(line.trim() + "\n");
                    }
                    index++;
                }
            } catch (IOException e) {
                logger.error("Unable to write to file", e);
            }
        } catch (SecurityException e) {
            logger.error("Unable to create directories and file to write to");
        }
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Error: Wrong number of arguments, should be JavaGrep regex rootPath outFile");
        }

        JavaGrepLambdaImp javaGrepLambdaImp = new JavaGrepLambdaImp();

        logger.debug("Variable 'regex' has been changed. Old value: {}, New value: {}", javaGrepLambdaImp.getRegex(), args[0]);
        javaGrepLambdaImp.setRegex(args[0]);
        logger.debug("Variable 'rootPath' has been changed. Old value: {}, New value: {}", javaGrepLambdaImp.getRootPath(), args[1]);
        javaGrepLambdaImp.setRootPath(args[1]);
        logger.debug("Variable 'outFile' has been changed. Old value: {}, New value: {}", javaGrepLambdaImp.getOutFile(), args[2]);
        javaGrepLambdaImp.setOutFile(args[2]);

        try {
            logger.info("Running method \"process\"");
            javaGrepLambdaImp.process();
        } catch (Exception e) {
            logger.error("Error: fail to process data", e);
        }
    }
}
