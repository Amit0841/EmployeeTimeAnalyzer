api="http://localhost:8080/customer/logini";

function login(){
let email=document.getElementById("email").value;
let password=document.getElementById("password").value;
let error=document.getElementById("error");
error.innerHTML=null;
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
let a= emailPattern.test(email);
if(a){
if(password.length>=8){

    const base64Credentials = btoa(`${email}:${password}`);

       fetch(`${api}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'Authorization': 'Basic ' + base64Credentials
        },
    })  .then(response =>{

        if(!response.ok){
            alert("Invalid email or password");
            error.innerHTML="Invalid email or password";
        }else {
            const jwtToken = response.headers.get("Authorization"); 
            localStorage.setItem('jwtToken',jwtToken); 
            return response.json();
          
        }   
        
    }).then(data => { 
       if(data.customerId!=null){
         alert("login Successfull");
         localStorage.setItem('userId', data.customerId); 

        window.location.href="../index.html";
      }
      })
   
    
}else{
    error.innerHTML="Password should be greater than or equal to eight character"  ;   
}

}else{
    error.innerHTML="Enter a valid email"  ;
}
}
