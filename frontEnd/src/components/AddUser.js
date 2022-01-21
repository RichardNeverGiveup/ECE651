import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function AddUser() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[username,setName]=useState('')
    const[password,setPassword]=useState('')
     const classes = useStyles();

  const handleClick=(e)=>{
    e.preventDefault()
    const user={username,password}
    console.log(user)
    fetch("http://127.0.0.1:8080/user/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(user)

  }).then(()=>{
    console.log("New user added")
  })
}

  return (

    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>User register</u></h1>

    <form className={classes.root} noValidate autoComplete="off">
    
      <TextField id="outlined-basic" label="Username" variant="outlined" fullWidth 
      value={username}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Password" variant="outlined" fullWidth
      value={password}
      onChange={(e)=>setPassword(e.target.value)}
      />
      <Button variant="contained" color="secondary" onClick={handleClick}>
  Submit
</Button>
    </form>
   
    </Paper>
    

    </Container>
  );
}