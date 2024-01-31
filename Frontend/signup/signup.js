api="http://localhost:8080/customer/add";
function register(){
    userName=document.getElementById("userName").value;
    email=document.getElementById("email").value;
    password=document.getElementById("password").value;
    mobile=document.getElementById("mobile").value;
    error=document.getElementById("error");
error.innerHTML=null;
    
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
let a= emailPattern.test(email);
if(a){
if(password.length>=8){

    requestBody={
        "customerId": 0,
        "name": userName,
        "email": email,
        "password": password,
        "mobileNumber": mobile,
        "role": "string"
      }
       fetch(`${api}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify(requestBody)
    }) 
    .then(response =>{

        if(!response.ok){
            alert("Something went wrong");
        }else {
            console.log("Response: "+response);
            alert("Register Successfull login now");
            window.location.href="../login/login.html";
        }   
        
    })
}else{
    error.innerHTML="Password should be greater than or equal to eight character"  ;   
}

}else{
    error.innerHTML="Enter a valid email"  ;
}

}