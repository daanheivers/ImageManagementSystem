import BaseAPI from "./base"

/**
 * @typedef ImsAPIUser
 * @property {number?} id
 * @property {string?} username
 */

/**
 * @typedef ImsAPIImageObject
 * @property {number?}   id
 * @property {string}    title
 * @property {Array<Byte>?} image
 */

const imsApi = new (class ImsAPI extends BaseAPI {
    constructor() {
        super()
        super()
    }

    /**
     * Logs the user in.
     *
     * @param   {{username: string, password: string}} data
     * @returns {JSON}
     */
    async login(data) {
        return this.request("/api/users/signin", { method: "POST", data })
    }

    /**
     * Creates a user.
     *
     * @param   {{username: string, password: string}}          data
     * @returns {Promise<ImsAPIUser>}
     */
    async createUser(data) {
        return this.request("/api/users/register", { method: "POST", data })
    }

    /**
     * Logout a user.
     *
     * @param   {number}                     id
     *
     */
    async logout(id, data) {
        return this.request(`/api/users/logout/${id}`, { method: "GET" })
    }

    /**
     * Creates an image.
     *
     * @param   {ImsAPIImageObject}        data
     * @returns {Promise<ImsAPIImageObject>}
     */
    async createImage(data) {
        return this.request("/api/unauthenticated/images", { method: "POST", data })
    }

    /**
     * Gets an image.
     *
     * @param   {number}                     id
     * @returns {Promise<ImsAPIImageObject>}
     */
    async getImage(imageId) {
        return this.request(`/api/unauthenticated/images/${imageId}`, {method: "GET"})
    }

    /**
     * Gets all images.
     *
     * @returns {Promise<ImsAPIImageObject>}
     */
    async getImages() {
        return this.request(`/api/unauthenticated/images`, {method: "GET"})
    }

    /**
     * Deletes an image.
     *
     * @param   {number}                     userId
     * @param   {number}                     imageId
     * @returns {Promise<ImsAPIImageObject>}
     */
    async deleteImage(imageId) {
        return this.request(`/api/unauthenticated/images/${imageId}`, { method: "DELETE" })
    }
})()

export default imsApi
