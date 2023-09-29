const htmlPattern = /<(html|HTML)>.*<\/(html|HTML)>/;
const tagPattern = /<([a-zA-Z]+)>/g;

function containsHTML(content) {
    if (htmlPattern.test(content)) {
        return true;
    }
    return false;
}

function countTags(content) {
    const matches = content.match(tagPattern);

    if(matches) {
        const tagCounts = {};
    
        matches.forEach(match => {
            const tagName = match.slice(1, -1);
    
            if (tagCounts[tagName]) {
                tagCounts[tagName]++;
            }
            else {
                tagCounts[tagName] = 1;
            }
        });
    
        return {
            contentType: "HTML",
            tags: tagCounts
        };
    }
    else {
        return {
            contentType: "HTML",
            tags: {}    
        }
    }
}


module.exports = { containsHTML, countTags };