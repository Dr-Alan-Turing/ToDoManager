/*
 * HEADER
 */

//to change language
function insertParam(key, value) {
    key = escape(key); value = escape(value);
    var keyValuePair = document.location.search.substr(1).split('&');
    if (keyValuePair == '') {
        document.location.search = '?' + key + '=' + value;
    }
    else {
        var i = keyValuePair.length; var x; while (i--) {
            x = keyValuePair[i].split('=');
            if (x[0] == key) {
                x[1] = value;
                keyValuePair[i] = x.join('=');
                break;
            }
        }
        if (i < 0) {
            keyValuePair[keyValuePair.length] = [key, value].join('=');
        }
        document.location.search = keyValuePair.join('&');
    }
}

/*
 * OVERVIEW TASKS PAGE
 */

function hideErrorMessage() {
    var errorHeader = document.getElementById("errorHeader");
    if (errorHeader !== null) {
        errorHeader.parentNode.removeChild(errorHeader);
    }
}

function showAddCategoryField(a) {
    var tr = a.parentNode.parentNode;
    //replace text with field
    var td2 = tr.children[1];
    td2.removeChild(td2.children[0]);
    var input = document.createElement("input");
    input.setAttribute("id", "addCategoryField");
    td2.appendChild(input);
    //set up '+' link
    var td1 = tr.children[0];
    var link = td1.children[0];
    link.setAttribute("onclick", "addCategory(this)");
}

function addCategory(a) {
    var tr = a.parentNode.parentNode;
    var td2 = tr.children[1];
    var input = td2.children[0];
    var name = input.value;
    window.location = "processCreateCategory.htm?name=" + name;
}

/*
 * CREATE TASK PAGE
 */

function selectRelevantOption(category){ //needed for when you create new task while in a category
    document.getElementById("categoriesSelect").value=category;
}