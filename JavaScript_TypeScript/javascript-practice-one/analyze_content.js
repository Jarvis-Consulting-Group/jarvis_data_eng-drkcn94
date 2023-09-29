const textCheck = require("./text_check.js");
const htmlCheck = require("./html_check.js");
const cssCheck = require("./css_check.js");

const { argv, exit } = require ('process');

const arg = argv[2];

function analyzeContent(arg) {

    if (!arg) {
        console.error('Usage of script is: node analyze_content.js <arg>');
        exit(1);
    }

    console.log(`Argument provided: ${arg}`);



    if (htmlCheck.containsHTML(arg)) {
        console.log(htmlCheck.countTags(arg));
    }

    else if (cssCheck.containsCSS(arg)) {
        console.log(cssCheck.countTargets(arg));
    }
    else {
        console.log(textCheck.countLines(arg));
    }
}




analyzeContent(arg);