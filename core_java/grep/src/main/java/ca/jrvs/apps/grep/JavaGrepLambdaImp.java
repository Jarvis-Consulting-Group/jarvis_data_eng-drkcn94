package ca.jrvs.apps.grep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JavaGrepLambdaImp extends JavaGrepImp{
    private static final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

    @Override
    public void process() throws IOException {
        super.process();
    }

    @Override
    public List<File> listFiles(String rootDir) {
        return super.listFiles(rootDir);
    }

    @Override
    public List<String> readLines(File inputFile) {
        return super.readLines(inputFile);
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
