import React from "react";
import "./index.css";
import App from "./App";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import reportWebVitals from "./reportWebVitals";
import {AddImage, Images, Login, Register} from "./routes";
import { createRoot } from "react-dom/client";
import 'bootstrap/dist/css/bootstrap.min.css';

const root = createRoot(document.getElementById("root"));

root.render(
    <React.StrictMode>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<App />}></Route>
                <Route path="/login" element={<Login />}></Route>
                <Route path="/register" element={<Register />}></Route>
                <Route path="/images" element={<Images />}></Route>
                <Route path="/add-image" element={<AddImage />}></Route>
            </Routes>
        </BrowserRouter>
    </React.StrictMode>
)
reportWebVitals()
