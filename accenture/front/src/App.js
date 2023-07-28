import "./App.css";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import FormFornecedor from "./components/fornecedor/fornecedor";
import FormEmpresa from "./components/empresa/empresa";
import DataGridEmpresa from "./components/empresa/dashEmpresa";
import DataGridFornecedor from "./components/fornecedor/dashFornecedor";
import Home from "./components/home";
const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/fornecedorGrid" element={<DataGridFornecedor />} />
        <Route path="/empresaGrid" element={<DataGridEmpresa />} />
        <Route path="/FormEmpresa" element={ <FormEmpresa />}/>

        <Route path="/FormFornecedor" element={<FormFornecedor />} />


      </Routes>
    </Router>
  );
};

export default App;