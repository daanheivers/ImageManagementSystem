import "../../index.css";
import "./Navbar.css";
import React from "react";
import { Link } from "react-router-dom";

class Navbar extends React.Component {
    render() {
        return (
            <nav className="Navbar">
                <Link to="/" className="block h-full">
                </Link>
            </nav>
        )
    }
}

export default Navbar
