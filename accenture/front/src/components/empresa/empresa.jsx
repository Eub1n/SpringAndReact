import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container, Button } from "@mui/material";
import { useState } from "react";
import Bar from "../Appbar";

export default function FormEmpresa() {
  const [name, setName] = useState("");
  const [cnpj, setCNPJ] = useState("");
  const [cep, setCEP] = useState("");
  const handleclick = (e) => {
    e.preventDefault();
    const empresa = { cnpj, name, cep };
    console.log(empresa);
    fetch("http://localhost:8080/empresas/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(empresa),
    });
  };

  return (
    <Container>
      <Bar />
      <h1>Adicionar empresa</h1>
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
          id="cep"
          label="CEP"
          variant="outlined"
          value={cep}
          onChange={(e) => setCEP(e.target.value)}
        />
        <br></br>
      </Box>
      <Button variant="contained" onClick={handleclick}>
        Cadastrar
      </Button>
    </Container>
  );
}
