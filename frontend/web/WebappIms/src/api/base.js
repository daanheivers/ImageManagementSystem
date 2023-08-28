import axios from "axios"
import merge from "lodash/merge"

/** @typedef {import("axios").AxiosInstance} AxiosInstance */
/** @typedef {import("axios").AxiosResponse} AxiosResponse */
/** @typedef {import("axios").AxiosRequestConfig} AxiosRequestConfig */

/**
 * @typedef BaseAPIOptions
 * @property {AxiosRequestConfig} axiosConfig
 */

/** Represents an API. */
export default class BaseAPI {
    constructor(options) {
        /** @type {BaseAPIOptions} */
        this.options = merge(
            {
                axiosConfig: {
                    baseURL: "http://localhost:8080",
                },
            },
            options
        )

        /** @type {AxiosInstance} */
        this._axios = axios.create(this.options.axiosConfig)
    }

    /**
     * Makes an HTTP request to the endpoint.
     *
     * @param   {string}                        endpoint
     * @param   {AxiosRequestConfig}            config
     * @param   {boolean}                       [getDataKey=true] Wether to get the `data` key from the response.
     * @returns {Promise<AxiosResponse|object>}                   The JSON data or body response.
     */
    async request(endpoint, config, getDataKey = true) {
        return this._axios(endpoint, config).then(response =>
            response.config.transitional.forcedJSONParsing && getDataKey
                ? response.data
                : response
        )
    }
}
