const plainTextPattern = /[\r\n]|\\n/g;

function countLines(content) {

    const lines = content.split(plainTextPattern);

    if (lines.length > 1) {
        return {
            contentType: "TEXT",
            lineNumber: lines.length
        }
    }
    else {
        return {
            contentType: "TEXT",
            lineNumber: 1
        }
    }

}

module.exports = { countLines };