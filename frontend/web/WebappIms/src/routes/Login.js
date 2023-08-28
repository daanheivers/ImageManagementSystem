import React, { useState } from "react"
import "../index.css"
import { useNavigate } from "react-router-dom"
import imsApi from "../api/imsapi";


function Login() {
    const navigate = useNavigate(),
        [inputs, setInputs] = useState({}),
        handleChange = event => {
            const { name, value } = event.target
            setInputs(values => ({ ...values, [name]: value }))
        },
        handleSubmit = async event => {
            event.preventDefault()
            await imsApi
                .login(inputs)
                .then(navigate("/"))
                .catch(
                    error =>
                        console.error(error) &
                        alert("Er ging iets mis... Check de console")
                )
        }

    return (
        <div className="app">
            <form onSubmit={handleSubmit}
                  to={"/"} className="form">
                <h1 className="text-3xl text-center w-full mb-4">Gip 4</h1>
                <div className="card card--inline">
                    <label>Username:</label>
                    <input
                        name= "username"
                        type="text"
                        value={inputs.username}
                        onChange={handleChange}
                    />
                </div>
                <div className="card card--inline">
                    <label>Password:</label>
                    <input
                        name = "password"
                        type="password"
                        value={inputs.password}
                        onChange={handleChange}
                    />
                </div>
                <button className="card card--inline" type="submit">
                    Login
                </button>
            </form>
        </div>
    )
}

export default Login
