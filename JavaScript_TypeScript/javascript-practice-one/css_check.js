const selectorPattern = /[^{}]+\s*\{[^{}]*\}/g;

function containsCSS(content) {
    if(selectorPattern.test(content)) {
        return true;
    }
    return false;
}

function countTargets(content) {
    const matches = content.match(selectorPattern);

    if (matches) {
        const selectorCounts = {};

        matches.forEach(match => {
            const [selector, rules] = match.split('{');
            const trimmedSelector = selector.trim();

            if(selectorCounts[trimmedSelector]) {
                selectorCounts[trimmedSelector]++;
            }
            else {
                selectorCounts[trimmedSelector] = 1;
            }
        });

        return {
            contentType: "CSS",
            selectors: selectorCounts
        }
    }
    else {
        return {
            contentType: "CSS",
            selectors: {}
        }
    }
}

module.exports = { containsCSS, countTargets };