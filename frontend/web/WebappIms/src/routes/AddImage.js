import React, {useState} from "react"
import "../index.css"
import { useNavigate } from "react-router-dom"
import imsApi from "../api/imsapi";


function AddImage() {
    const navigate = useNavigate(),
        [inputs, setInputs] = useState({}),
        handleChange = event => {
            const { name, value } = event.target
            setInputs(values => ({ ...values, [name]: value }))
        },
        handleSubmit = async event => {
            event.preventDefault()
            await imsApi
                .createImage(inputs)
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
                <h1 className="text-3xl text-center w-full mb-4">Add Image To Delaystagram</h1>
                <div className="card card--inline">
                    <label>Title:</label>
                    <input
                        name= "title"
                        type="text"
                        value={inputs.title}
                        onChange={handleChange}
                    />
                </div>
                <div className="card card--inline">
                    <label>Password:</label>
                    <input
                        name = "image"
                        type="file"
                        value={inputs.image}
                        onChange={handleChange}
                    />
                </div>
                <button className="card card--inline" type="submit">
                    Add Image
                </button>
            </form>
        </div>
    )
}

export default AddImage
