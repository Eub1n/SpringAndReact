import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container, Button } from "@mui/material";
import { useState } from "react";
import Bar from "../Appbar";


export default function FormFornecedor() {
  const [name, setName] = useState("");
  const [cnpj, setCNPJ] = useState("");
  const [email, setEmail] = useState("");
  const [cep, setCEP] = useState("");
  const [rg, setRG] = useState("");
  const [nasc, setNasc] = useState("");
  const handleclick = (e) => {
    e.preventDefault();
    const fornecedor = { cnpj, name, email, cep, rg, nasc };
    console.log(fornecedor);
    fetch("http://localhost:8080/fornecedores/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(fornecedor),
    });
  };

  return (
    <Container>
      <Bar />
      <h1>Adicionar fornecedor</h1>
      <Box
        component="form"
        sx={{
          "& > :not(style)": { m: 1, width: "25ch" },
        }}
        noValidate
        autoComplete="off"
      >
        <TextField
          id="cnpj"
          label="CNPJ ou CPF"
          variant="outlined"
          value={cnpj}
          onChange={(e) => setCNPJ(e.target.value)}
        />
        <TextField
          id="name"
          label="Nome"
          variant="outlined"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <br></br>
        <TextField
          id="email"
          label="E-mail"
          variant="outlined"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <TextField
          id="cep"
          label="CEP"
          variant="outlined"
          value={cep}
          onChange={(e) => setCEP(e.target.value)}
        />
        <br></br>
        <TextField
          id="rg"
          label="RG"
          variant="outlined"
          value={rg}
          onChange={(e) => setRG(e.target.value)}
        />
         <TextField
          id="rg"
          label="Data de Nascimento"
          variant="outlined"
          value={nasc}
          onChange={(e) => setNasc(e.target.value)}
        />
      </Box>
      <Button variant="contained" onClick={handleclick}>
        Cadastrar
      </Button>
    </Container>
  );
}
