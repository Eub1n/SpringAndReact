import * as React from "react";
import { Link } from "react-router-dom";
import Bar from "./Appbar";

export default function Home() {
  return (
    <>
      <div>
        <Bar />
        <nav>
          <ul>
            <li>
              <Link to="/fornecedorGrid">Grid de Fornecedores</Link>
            </li>
            <li>
              <Link to="/empresaGrid">Grid de Empresas</Link>
            </li>
            <li>
              <Link to="/FormEmpresa">Cadastro Empresa</Link>
            </li>
            <li>
              <Link to="/FormFornecedor">Cadastro Fornecedor</Link>
            </li>
          </ul>
        </nav>
      </div>
    </>
  );
}
