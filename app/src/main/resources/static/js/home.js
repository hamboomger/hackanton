function constructKeywordElement(keyword) {
    let controlDiv = createElement("div", "control");
    controlDiv.id = "keyword-" + keyword;
    let tagsDiv = createElement("div", "tags has-addons");
    let tagDiv = createElement("a", "tag");
    tagDiv.innerHTML = keyword;
    let deleteBtnDiv = createElement("a", "tag is-delete");
    deleteBtnDiv.addEventListener("click", function () {
        controlDiv.parentNode.removeChild(controlDiv);
        fetch(`/user/config/keywords/${keyword}`, {
            method: "DELETE",
            credentials: "same-origin"
        })
    });

    controlDiv.appendChild(tagsDiv);
    tagsDiv.appendChild(tagDiv);
    tagsDiv.appendChild(deleteBtnDiv);

    return controlDiv;
}

function createElement(name, classAttributes) {
    let element = document.createElement(name);
    element.setAttribute("class", classAttributes);
    return element;
}

function addKeywordToDOM(keyword) {
    let keywordsWrapper = document.getElementById("keywords-wrapper");
    let keywordElement = constructKeywordElement(keyword);
    keywordsWrapper.appendChild(keywordElement);
}

function getUserConfig() {
    return fetch("/user/config", {
        credentials: "same-origin"
    }).then( response => {
        if(response.ok) {
            return response.json()
        }
    });
}

function keywordExists(keyword) {
    return getUserConfig().then( config => {
        return config.keywords.contains(keyword)
    })
}

function addKeywordToServer(keyword) {
    fetch(`/user/config/keywords/${keyword}`, {
        method: "PUT",
        credentials: "same-origin"
    }).then( response => {
        if(!response.ok)
            console.error("Error: " + response.message)
    }, error => {
        console.error("Error: " + error)
    });
    console.log(`Keyword ${keyword} added`)
}

$(document).ready(function() {
    $("#keywords-wrapper").ready(function () {
        getUserConfig().then( userConfig => {
            userConfig.keywords.forEach(keyword => {
                addKeywordToDOM(keyword);
            })
        });
    });

    $("#add-keyword-btn").on("click", function () {
        let keyword = document.getElementById("keyword-textfield").value;

        if(!keywordExists(keyword)) {
            addKeywordToDOM(keyword);
            addKeywordToServer(keyword)
        }
    });
});
