
const deleteUser =  async (id) =>{
  if(confirm("Esta Seguro de querer eliminar?")){
        await fetch("http://localhost:8080/api/users/delete/" + id,{
         method:'delete',
         headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization':localStorage.token
                             },
         });
        location.reload();
  }

  };
