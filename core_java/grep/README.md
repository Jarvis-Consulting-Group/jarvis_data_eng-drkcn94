# Introduction
The Java grep program is an application designed to allow the search of patterns within .txt files and storing matched results in an output file. The technologies used to develop this application were Java with the usage of lambdas and streams for processing files and writing to an output file and Docker for containerization and deployment of the application. Git and GitHub were used for version control of the code and Apache Maven was used for managing the application build process and dependency management.
# Quick Start
1. Install Docker
2. Input the command ``docker pull drkcandocker/grep:latest`` in the terminal to pull the latest version of the grep program
3. Input the command ``docker run --rm -v `pwd`/data:/data -v `pwd`/log:/log ${docker_user}/grep [regex pattern] [data source] [outfile file directory/name]`` to start a Docker container that will run the application with provided commands from the user, it is recommended for the user to adjust the volume paths to where data is stored and where results should be written to.
# Implementation
## Pseudocode
The implementation of the application revolves around a main function called ``process()`` which handles the search for lines in files that match the pattern provided by the user.
```

process()
    # Collection used to store the strings that match the pattern provided by the user
    matchedLines = []
    
    # Traverse through each directory in the rootDir provided by user to find a file
    for file in listFiles(rootDir)
    
        # Read through the file line by line
        for line in readLines(file)
        
            # Check if the line provided from the file matches the pattern provided by user, if true, add the line to the matchedLines collection.
            if containsPattern(line)
                matchedLines.add(line)
    
    # Write the matched lines to a file name provided by the user
    writeToFile(matchedLines);
```

## Performance Issue
There is a possibility of a ``OutOfMemoryError`` exception if files provided to the grep application exceed the default heap size. This can be mitigated by running the application with the flags -XMs -Xmx and setting the heap initial and max size to larger values. This issue can also be mitigated by using streams which would lower the memory overhead required to run the application.

# Test
Testing of the application was done by using slf4j and logback for logging details regarding changes in data in the application and status updates regarding what methods are currently being executed.
```
java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp .*Romeo.*Juliet.* ./data ./out/grep.txt

16:56:48.503 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Variable 'regex' has been changed. Old value: null, New value: .*Romeo.*Juliet.*
16:56:48.552 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Variable 'rootPath' has been changed. Old value: null, New value: ./data
16:56:48.552 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Variable 'outFile' has been changed. Old value: null, New value: ./out/grep_output.txt
16:56:48.552 [main] INFO ca.jrvs.apps.grep.JavaGrep -- Running method "process"
16:56:48.552 [main] INFO ca.jrvs.apps.grep.JavaGrep -- Processing Files for lines
16:56:50.934 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Pattern .*Romeo.*Juliet.* is in Line     Is father, mother, Tybalt, Romeo, Juliet,
16:56:50.945 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Pattern .*Romeo.*Juliet.* is in Line Enter Romeo and Juliet aloft, at the Window.
16:56:51.067 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Pattern .*Romeo.*Juliet.* is in Line     And Romeo dead; and Juliet, dead before,
16:56:51.068 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Pattern .*Romeo.*Juliet.* is in Line     Romeo, there dead, was husband to that Juliet;
16:56:51.837 [main] INFO ca.jrvs.apps.grep.JavaGrep -- Writing lines to ./out/grep_output.txt
16:56:51.837 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Creating new try with resources statement for writing to output file
16:56:51.838 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Adding     Is father, mother, Tybalt, Romeo, Juliet, to ./out/grep_output.txt
16:56:51.838 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Adding Enter Romeo and Juliet aloft, at the Window. to ./out/grep_output.txt
16:56:51.839 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Adding     And Romeo dead; and Juliet, dead before, to ./out/grep_output.txt
16:56:51.839 [main] DEBUG ca.jrvs.apps.grep.JavaGrep -- Adding     Romeo, there dead, was husband to that Juliet; to ./out/grep_output.txt
```
# Deployment
The application was cleaned and packaged by Maven to remove unnecessary files before creating the .jar file. The application was then Dockerized by creating a Dockerfile with instructions stating what dependencies are needed, what files to provide in the image and what would be the entry method of using the application in the container. The image was then pushed to an image repository hosted by DockerHub for easy accessibility. 

# Improvement
The project can be improved by various means such as:
1. Reduce the amount logging messages provided by the application (it is unnecessary to be logging every pattern match or writing of a line to a file)
2. Better implementation of exception handling (understanding what kind of exceptions there are, graceful recovery)
3. Better memory management by using buffers and streams instead of saving files into memory to be read. (Alternative implementation with streams is in ``JavaGrepLambdaImp.java``) 