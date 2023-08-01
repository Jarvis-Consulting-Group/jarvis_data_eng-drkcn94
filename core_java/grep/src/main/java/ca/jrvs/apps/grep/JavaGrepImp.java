package ca.jrvs.apps.grep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaGrepImp implements JavaGrep{

    private static final Logger logger = LoggerFactory.getLogger(JavaGrep.class);
    private String regex;
    private String rootPath;
    private String outFile;
    @Override
    public void process() throws IOException {
        List<String> matchedLines = new ArrayList<>();
        logger.info("Beginning search for files");
        for (File file : listFiles(rootPath)) {
            logger.info("Retrieving lines from file");
            for (String line : readLines(file)){
                if (containsPattern(line)) {
                    matchedLines.add(line);
                }
            }
        }
        logger.info("Writing lines to {}", this.outFile);
        writeToFile(matchedLines);
    }

    @Override
    public List<File> listFiles(String rootDir) {
        List<File> fileList = new ArrayList<>();
        File root = new File(rootDir);

        addFilesToList(root, fileList);

        return fileList;
    }

    private void addFilesToList(File directory, List<File> fileList) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    logger.debug("file: {} is a directory, continuing depth traversal", file);
                    addFilesToList(file, fileList);
                }
                else {
                    logger.debug("file: {} is a file, adding to List fileList", file);
                    fileList.add(file);
                }
            }
        }
    }

    @Override
    public List<String> readLines(File inputFile) {
        List<String> lines = new ArrayList<>();

        logger.debug("Creating new try with resources statement for reading input file");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            String line;
            logger.debug("Adding lines to List");
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            logger.error("Error attempting to read from file {}", inputFile);
        }
        return lines;
    }

    @Override
    public boolean containsPattern(String line) {

        Pattern pattern = Pattern.compile(this.regex);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            logger.debug("Pattern {} is in Line {}", this.regex, line);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {

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

        JavaGrepImp javaGrepImp = new JavaGrepImp();

        logger.debug("Variable 'regex' has been changed. Old value: {}, New value: {}", javaGrepImp.getRegex(), args[0]);
        javaGrepImp.setRegex(args[0]);
        logger.debug("Variable 'rootPath' has been changed. Old value: {}, New value: {}", javaGrepImp.getRootPath(), args[1]);
        javaGrepImp.setRootPath(args[1]);
        logger.debug("Variable 'outFile' has been changed. Old value: {}, New value: {}", javaGrepImp.getOutFile(), args[2]);
        javaGrepImp.setOutFile(args[2]);

        try {
            logger.info("Running method \"process\"");
            javaGrepImp.process();
        } catch (Exception e) {
            javaGrepImp.logger.error("Error: fail to process data", e);
        }
    }
}
