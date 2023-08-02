package ca.jrvs.apps.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExcImp implements RegexExc{

    private static final Logger logger = LoggerFactory.getLogger(RegexExc.class);

    @Override
    public boolean matchJpeg(String filename) {
        Pattern pattern = Pattern.compile("..*\\.jpe?g$");
        Matcher matcher = pattern.matcher(filename);
        return matcher.find();
    }

    @Override
    public boolean matchIp(String ip) {
        Pattern pattern = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
        Matcher matcher = pattern.matcher(ip);
        return matcher.find();
    }

    @Override
    public boolean isEmptyLine(String line) {
        Pattern pattern = Pattern.compile("^$");
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public static void main(String[] args) {
        boolean result;
        RegexExcImp regexExcImp = new RegexExcImp();

        for (String arg : args) {
            result = regexExcImp.matchJpeg(arg);
            logger.info("{} is a {} .jpg pattern", arg, result);

            result = regexExcImp.matchIp(arg);
            logger.info("{} is a {} IPv4 pattern", arg, result);

            result = regexExcImp.isEmptyLine(arg);
            logger.info("{} is a {} empty line", arg, result);
        }
    }
}
