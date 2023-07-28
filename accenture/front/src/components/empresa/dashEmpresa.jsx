import * as React from "react";
import Box from "@mui/material/Box";
import { DataGrid } from "@mui/x-data-grid";
import axios from "axios";
import { useState, useEffect } from "react";
import Button from "@mui/material/Button";
import Bar from "../Appbar";

export default function DataGridFornecedor() {
  const [fornecedores, setFornecedores] = useState([]);

  const [fornecedorId, setFornecedorId] = useState();

  const [fornecedorUpdated, setFornecedorUpdated] = useState();


  useEffect(() => {
    loadFornecedores();
  }, []);

  const loadFornecedores = async () => {
    const result = await axios.get("http://localhost:8080/fornecedores");
    setFornecedores(result.data);
  };

  const handleDelete = async () => {
    if (!fornecedorId) return;
    try {
      await axios.delete(`http://localhost:8080/fornecedores/${fornecedorId}`);
      loadFornecedores();
    } catch (error) {
      console.error("Erro ao excluir item:", error);
    }
  };

  const handleUpdate = async () => {
    if (!fornecedorUpdated) return;
    try {
      await axios.put(`http://localhost:8080/fornecedores/${fornecedorUpdated.id}`,fornecedorUpdated);
      loadFornecedores();
    } catch (error) {
      console.error("Erro ao excluir item:", fornecedorUpdated);
    }
  };

  const columns = [
    { field: 'id', headerName: 'ID', width: 90 },
    {
      field: 'cep',
      headerName: 'CEP',
      type: 'number',
      width: 110,
      editable: true,
    },
    {
      field: 'cnpj',
      headerName: 'CNPJ',
      type: 'number',
      width: 110,
      editable: true,
    },
    {
      field: 'name',
      headerName: 'Nome',
      width: 150,
      editable: true,
    },

  ];
  
  return (
    
    <Box sx={{ height: 400, width: "100%" }}>
      <Bar />
      <h1>Grid Fornecedores</h1>
      <DataGrid
        onRowClick={({row}) => setFornecedorId(row)}
        editMode="row"
        rowModel="server"
        processRowUpdate={(row) => {setFornecedorUpdated(row); return row}}
        onProcessRowUpdateError={(err)=> console.error(err)}
        rows={fornecedores}
        columns={columns}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
        pageSizeOptions={[5]}
      />
      <Button
        variant="contained"
        color="error"
        onClick={handleDelete}
        disabled={!fornecedorId}
      >
        Deletar
      </Button>
      <Button
        variant="contained"
        onClick={handleUpdate}
        disabled={!fornecedorUpdated}
      >
        Editar
      </Button>
    </Box>
  );
}
