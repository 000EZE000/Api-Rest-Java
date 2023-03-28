// Call the dataTables jQuery plugin



function templateTableUser(users)  {
let template = "";
users.forEach(user=>{
let buttonDelete = '<td><a href="#" onclick="deleteUser(' + user.id + ')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td>'
template = template + `<tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                ${buttonDelete}
            </tr>`
})

return template
}




async function fetchUsers(){
const jsonUsers = await fetch("http://localhost:8080/api/users/all",{
                            method:"GET",
                            headers:{
                                    'Accept': 'application/json',
                                    'Content-Type': 'application/json',
                                    'Authorization':localStorage.token
                                    }
                            });


return await jsonUsers.json()
}


const setTitle = () =>{
document.querySelector('#email-user').innerText = localStorage.email;
}

$(document).ready(async function() {

  $('#table-user').DataTable();
  try{
    const users = await fetchUsers();
    setTitle()
    document.querySelector("#table-user tbody").outerHTML = templateTableUser(users);

  }catch(error){
    document.querySelector("#table-user tbody").outerHTML = templateTableUser([{name:"error",email:"",phone:"",id:""}]);
    console.log("error");
  };

});








