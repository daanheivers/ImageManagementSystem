import './index.css';
import React, {useState} from "react";
import { Link } from "react-router-dom";
import {Login} from "./routes";

function App() {

  return (
      <div className="app">

        <main className="text-center">
          <h1 className="text-4xl">
            Welcome to <strong>Delaystagram</strong>!
          </h1>

          <h5 className="text-lg mt-8 text-gray-400">
            What are you up to?
          </h5>

          <div className="mt-4">
            <div className="card card--inline card--hoverTranslate">
              <Link className="cardTitle" to="/images">
                Show all images
              </Link>
            </div>
            <div className="card card--inline card--hoverTranslate">
              <Link className="cardTitle" to="/add-image">
                Add Image
              </Link>
            </div>
            <div className="card card--inline card--hoverTranslate">
              <Link className="cardTitle" to="/login">
                Login
              </Link>
            </div>
          </div>
        </main>
      </div>
  );
}

export default App;
