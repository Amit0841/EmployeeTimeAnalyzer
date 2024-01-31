url="http://localhost:8080/cart";

let display1=document.getElementById("displayMobile")
let price=document.getElementById("price");
let itemCount=document.getElementById("item");
let sum=0;
let item=0;

fetchApi();
function fetchApi() {
    display1.innerHTML=null;

    let userId = localStorage.getItem('userId');
   let jwt=localStorage.getItem('jwtToken');

        fetch(`${url}/${userId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + jwt
            },
        }) 
    .then((request)=>{
        if(request.ok){
            let login=document.getElementById("login")
            let logout=document.getElementById("logoutButton")
            let reg=document.getElementById("reg")
        
            login.style.display = 'none';
            reg.style.display = 'none';
            logout.style.display = 'inline-block';
        }  
   return request.json();
    })
    .then((data)=>{
   
   mobileData=data;
   display(data);
    })
    .catch((err)=>{
        let p=document.createElement("p")
        p.innerHTML="Login First"
       
        display1.append(p);
   console.log(err)
    })
}

function display(element) {
    item=0;
    sum=0;
element.forEach(element => {
     let div=document.createElement("div");
    let img=document.createElement("img")
    img.src=element.image
    let p=document.createElement("p")
    p.innerText=element.mobileName
 
    let span=document.createElement("span")
    let p1=document.createElement("p")
    p1.innerText="₹ "+element.price
    sum+=element.price;
    item++;
    itemCount.innerHTML=item;
    let button=document.createElement("button")
    button.setAttribute("id", "delete-Button");
    button.innerText="Remove"
    price.innerHTML=sum;

    button.addEventListener("click",()=>{
   console.log(element.mobileId);
   let userId = localStorage.getItem('userId');
   let jwt=localStorage.getItem('jwtToken');
        fetch(`${url}/delete/${userId}/${element.mobileId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + jwt
            },
        }) 
        .then(response =>{
           
            if(!response.ok){
                alert("Medicine already exist");
            }else {
                alert("Item Deleted successfully");
                fetchApi();
            }   
            
        })

    });

    span.append(p1,button);
    div.append(img,p,span);
    display1.append(div) ;
});
   
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
    itemCount.innerHTML=0;
    price.innerHTML=0;
    fetchApi();
   }