import React, { useState } from "react"
import clsx from "clsx"
import Modal from "react-modal"
import Navbar from "../UIComponents/navbar/Navbar"
import "../index.css"
import imsApi from "../api/imsapi";
import {Login} from "./index";
import authHeader from "../api/authHeader";

/**
 * @typedef {object[]} ImagesData
 * @property {number}   id
 * @property {string}   title
 * @property {Array<Byte>}   image
 */

Modal.setAppElement("#root")

function Images(props) {

    const [activeElementId, setActiveElementId] = useState(NaN),
        /** @type {[ImagesData]} */
        [imagesData, setimagesData] = useState([])

    /** @param {MouseEvent} event */
    function handleClick(event) {
        const id = Number.parseInt(event.target.dataset.id)
        setActiveElementId(activeElementId === id ? NaN : id)
    }

    async function loadHandler() {
        const data = await imsApi
            .getImages()
            .catch(
                error =>
                    console.error(error) &
                    alert("Er ging iets mis... Check de console") || []
            )

        setimagesData(data)
    }

    function renderView() {

        const viewItems = []

        imagesData.forEach(image => {
            viewItems.push(
                <div
                    key={image.id}
                    data-id={image.id}
                    className={clsx("tableView__item", {
                        " tableView__item--active":
                            activeElementId === image.id,
                    })}
                    onClick={handleClick}
                >
                    <h5 className="tableView__itemName">{image.title}</h5>
                    <div className="tableView__itemRight">
                        {image.image}
                    </div>
                </div>
            )
        })

        return (
            <div
                className={clsx("tableView", {
                    " tableView--no-items": viewItems.length === 0,
                })}
            >
                {viewItems.length > 0 ? viewItems : <h3>No Images...</h3>}
            </div>
        )
    }

    return (
        <div className="app managers" onLoad={loadHandler()}>
            <Navbar />

            <main className="tableView__container">
                {renderView()}
            </main>
        </div>
    )
}

export default Images
