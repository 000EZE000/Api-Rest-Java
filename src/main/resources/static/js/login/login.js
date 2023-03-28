$(document).ready( () =>{});

const sendLoginForApi = async (body) =>{
    const result = await fetch( "http://localhost:8080/api/auth/login",{
                    method:"POST",
                    headers:{
                       'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Authorization':localStorage.token
                          },
                    body:JSON.stringify(body),
                    });
    return result.text();

};



const getInput = () =>{

    const email = document.getElementById("inputEmail").value;
    const password = document.getElementById("inputPassword").value;

    const newUser ={
        email,
        password,
    };

    return newUser;

};


const loginUser = async () =>{

    const {email , password} = getInput();
   if( !email || !password ) return alert("the data is empty");
   let result;
   try{
       result = await sendLoginForApi({email, password});
   }catch(error){
        return alert(error.message);
   }
    console.log({result}, result === "OK");

    if(result !== 'FAIL'){
    resetInputs();
    localStorage.token = result;
    localStorage.email = email;
    return window.location.href = 'users.html';
    }

    return alert("Login the credentials are incorrect , please try again");
};







const resetInputs = () =>{
    document.getElementById("inputEmail").value ="";
    document.getElementById("inputPassword").value ="";
}
