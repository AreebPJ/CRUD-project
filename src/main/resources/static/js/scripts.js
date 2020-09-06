function displayUsers(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState == 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);
                // adding an element to the body example
                // let elem = document.createElement('div');
                //elem.textContent = "hello world";
                //document.body.appendChild(elem);

                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {
                    // console.log(el); // prints whole element
                    // console.log(el.name); // allows access to specific value

                    // adding title to the body of the page
                    let elem = document.createElement('div');
                    elem.setAttribute("class","container");
                    //elem.setAttribute("class","color");
                    let aelem = document.createElement('div');
                    aelem.setAttribute("class","row");
                    let belem = document.createElement('div');
                    belem.setAttribute("class","col-lg-12");
                    let celem = document.createElement('div');
                    celem.setAttribute("class","suin");
                    elem.appendChild(aelem);
                    aelem.appendChild(belem);
                    belem.appendChild(celem);

                    let header = document.createElement('h1');
                    header.textContent = "Client name: " + el.fName+"  "+" " + " "+"ID: " +" " + el.user_id ;
                    celem.appendChild(header);
                    el.fit.forEach(fits => {
                        console.log(fits) // print all fits for each user
                        let title = document.createElement('p');
                        let description = document.createElement('p');
                        let fid = document.createElement('p');
                        title.textContent = "Title: " + fits.title;
                        description.textContent = "Description: " + fits.description;
                        fid.textContent = "ID:" + fits.id;
                        celem.appendChild(title);
                        celem.appendChild(description);
                        celem.appendChild(fid);
                    })
                    document.body.appendChild(elem);
                });
            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://34.105.155.158:8080/getAllUsers");
    req.send();
}

function submitClient(){
    let elements = document.getElementById("clientForm").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://34.105.155.158:8080/createUser");
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({
        fName: obj.fName,
        lName: obj.lName,
        gender: obj.gender
    }));
}
function submitFit(){
    let elements = document.getElementById("fitForm").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://34.105.155.158:8080/createFit");
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({
        title: obj.title,
        description: obj.description,
        users:
            {user_id: Number(obj.userId)}
    }));
}
function findUserById(){
    let cid = document.getElementById("client_id");
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState == 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);

                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {

                    // console.log(el); // prints whole element
                    // console.log(el.name); // allows access to specific value
                    if (el.user_id === cid.value()){
                        let elem = document.createElement('div');
                        elem.setAttribute("class","container");
                        let header = document.createElement('h1');
                        header.textContent = "Client name: " + el.fName+"  "+" " + " "+"ID: " +" " + el.user_id ;
                        elem.appendChild(header);

                        el.fit.forEach(fits => {
                            console.log(fits) // print all fits for each user
                            let title = document.createElement('p');
                            let description = document.createElement('p');
                            title.textContent = "Title: " + fits.title;
                            description.textContent = "Description: " + fits.description;
                            elem.appendChild(title);
                            elem.appendChild(description);
                        })
                        document.body.appendChild(elem);
                    } else{
                        console.log("Error");

                    }
                });
            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://34.105.155.158:8080/getUserById/{id}");
    req.send();
}
function updateClient(){
    let elements = document.getElementById("updateForm").elements;
    let upd = {};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        upd[item.name] = item.value;
    }
    const URL = "http://34.105.155.158:8080/updateUser/" + upd.uid;

    const req = new XMLHttpRequest();
    req.open("PUT", URL);
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({
        fName: upd.fName,
        lName: upd.lName,
        gender: upd.gender
    }));
}
function deleteClient(){
    let elements = document.getElementById("DeleteForm").elements;
    let del = {};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        del[item.name] = item.value;
    }
    const URL = "http://34.105.155.158:8080/deleteUser/" + del.uid;

    const req = new XMLHttpRequest();
    req.open("DELETE", URL);
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.send();
}
function deleteFit(){
    let elements = document.getElementById("DeleteFit").elements;
    let delfit = {};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        delfit[item.name] = item.value;
    }
    const URL = "http://34.105.155.158:8080/delete/" + delfit.fid;

    const req = new XMLHttpRequest();
    req.open("DELETE", URL);
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.send();
}