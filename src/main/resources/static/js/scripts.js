function displayUsers(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
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
                    let header = document.createElement('h1');
                    header.textContent = "User name: " + el.fName;
                    elem.appendChild(header);
                    el.fit.forEach(fit => {
                        console.log(fit) // print all notes for each notebook
                        let title = document.createElement('p');
                        let description = document.createElement('p');
                        title.textContent = "Title: " + fit.title;
                        description.textContent = "Description: " + fit.description;
                        elem.appendChild(title);
                        elem.appendChild(description);
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
    req.open("GET", "http://localhost:8080//getAllUsers");
    req.send();
}

// function submitNote(){
//     let elements = document.getElementById("notesForm").elements;
//     let obj ={};
//     for(let i = 0 ; i < elements.length - 1 ; i++){
//         let item = elements.item(i);
//         obj[item.name] = item.value;
//     }
//
//     const req = new XMLHttpRequest();
//     req.open("POST", "http://localhost:8080/createNote");
//     req.onload = () => {
//         if (req.status === 200 && req.readyState == 4) {
//             console.log("Server Responded with: " + req.responseText);
//         } else {
//             console.log("Oops...");
//         }
//     };
//     req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
//     req.send(JSON.stringify({ title: obj.title, description: obj.description, noteBook:{ id: Number(obj.noteBookId)} }));
// }