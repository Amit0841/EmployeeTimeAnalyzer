url="http://localhost:8080/mobile/get";
url2="http://localhost:8080/cart";

mobileData=[];
let display1=document.getElementById("displayMobile")

fetchApi();
function fetchApi(){
    // 
    let userId1 = localStorage.getItem('userId');
    let jwt=localStorage.getItem('jwtToken');
 
         fetch(`${url}/${userId1}`, {
             method: 'GET',
             headers: {
                 'Content-Type': 'application/json',
                 'Accept': 'application/json',
                 'Authorization': 'Bearer ' + jwt
             },
         }) .then(response =>{
             
    if(response.ok){
        let login=document.getElementById("login")
        let logout=document.getElementById("logoutButton")
        let reg=document.getElementById("reg")
    
        login.style.display = 'none';
        reg.style.display = 'none';
        logout.style.display = 'inline-block';
    }  
            
        })

    // 
    fetch(url)
    .then((request)=>{
   return request.json()
    })
    .then((data)=>{
   
   mobileData=data;
   display(data);
    })
    .catch((err)=>{
        let p=document.createElement("p")
        p.innerHTML="Backend Not Running"
        display1.append(p);
   console.log(err)
    })
}
function find(){
  let name=  document.getElementById("input").value;
    api=`http://localhost:8080/mobile/find/${name}`;
    fetch(api)
    .then((request)=>{
   return request.json()
    })
    .then((data)=>{
   
   mobileData=data;
   display(data);
    })
    .catch((err)=>{
        let p=document.createElement("p")
        p.innerHTML="Backend Not Working"
        display1.append(p);
   console.log(err)
    })
}


function display(element){
    console.log(element);
    display1.innerHTML=null;
element.forEach(element => {
     let div=document.createElement("div");
    let img=document.createElement("img")
    img.src=element.image
    let p=document.createElement("p")
    p.innerText=element.mobileName
 
    let span=document.createElement("span")
    let p1=document.createElement("p")
    p1.innerText="₹ "+element.price
    let button =document.createElement("button")
    button.innerText="Add To Cart" 

    button.addEventListener("click",()=>{
   console.log(element.mobileId);
   requestBody={
    "cartId": 0
   }
   let userId = localStorage.getItem('userId');
   let jwt=localStorage.getItem('jwtToken');
          
        fetch(`${url2}/${userId}/${element.mobileId}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + jwt
            },
            body: JSON.stringify(requestBody)
        }) 
        .then(response =>{
            console.log("Response: "+response);
            // if(!response.ok){
            //     // alert("login first!");
            //     throw new Error("Network response was not ok");
                
            // } 
            if(!response.ok){
                alert("Mobile already added");
            }else {
                console.log("Response: "+response);
                alert("item added successfully");
            }   
            
        })

    });

    span.append(p1,button);
    div.append(img,p,span);
    display1.append(div) ;
});
   
}

function addToCart(id){
    requestBody={
        "cartId": 0
       }
    let userId = localStorage.getItem('userId');
    let jwt=localStorage.getItem('jwtToken');
    fetch(`${url2}/${userId}/${id}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'Authorization': 'Bearer ' + jwt
        },
        body: JSON.stringify(requestBody)
    }) 
    .then(response =>{
        console.log("Response: "+response);
        // if(!response.ok){
        //     // alert("login first!");
        //     throw new Error("Network response was not ok");
            
        // } 
        if(!response.ok){
            alert("Mobile already added");
        }else {
            console.log("Response: "+response);
            alert("item added successfully");
        }   
        
    })

}
function logout(){
 localStorage.clear();
alert("Logout Success")

 let login=document.getElementById("login")
 let logout=document.getElementById("logoutButton")
 let reg=document.getElementById("reg")

 login.style.display = 'inline-block';
 reg.style.display = 'inline-block';
 logout.style.display = 'none';

}