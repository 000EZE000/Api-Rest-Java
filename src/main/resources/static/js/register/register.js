$(document).ready( () =>{});

const sendUserForApi = async (body) =>{
    await fetch( "http://localhost:8080/api/users/create", {
                method:"POST",
                headers:{
                      'Accept': 'application/json',
                      'Content-Type': 'application/json',
                      'Authorization':localStorage.token
                    },
                body:JSON.stringify(body),
                });

};



const getInput = () =>{
    const result = [];
    const name = document.getElementById("inputName").value;
    const lastName = document.getElementById("inputLastName").value;
    const email = document.getElementById("inputEmail").value;
    const phone =Number(document.getElementById("inputPhone").value);
    const password = document.getElementById("inputPassword").value;
    const repeatPassword = document.getElementById("inputRepeatPassword").value;

    result[0] =  password !== repeatPassword;

    const newUser ={
        name,
        lastName,
        email,
        phone,
        password,
    };

    result[1] = newUser;
    return result;

};


const registerUser = async () =>{

    const inputs = getInput();
   if(inputs[0] ) return alert("Passwords do not match");
   try{
          await sendUserForApi(inputs[1]);
   }catch(error){
        return alert(error.message)
   }

    resetInputs();
    alert("The user has been created successfully")
};







const resetInputs = () =>{
    document.getElementById("inputName").value ="";
    document.getElementById("inputLastName").value="";
    document.getElementById("inputEmail").value ="";
    document.getElementById("inputPhone").value ="";
    document.getElementById("inputPassword").value ="";
    document.getElementById("inputRepeatPassword").value ="";
}
