package com.hnk.wallpaper.data.api

import com.hnk.wallpaper.data.enties.CollectionMediaResponse
import com.hnk.wallpaper.data.enties.CollectionsResponse
import com.hnk.wallpaper.data.enties.CuratedPhotosResponse
import com.hnk.wallpaper.data.enties.PexelsResponse
import com.hnk.wallpaper.data.enties.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PexelsApi {

    /**
     * Fetches curated photos from the Pexels API.
     *
     * @param page The page number to retrieve.
     * @param perPage The number of photos per page.
     * @return A [Response] containing [CuratedPhotosResponse] with the list of curated photos.
     */
    @GET("v1/curated")
    suspend fun getCuratedPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<CuratedPhotosResponse>

  @GET("v1/popular")
    suspend fun getPopularPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<CuratedPhotosResponse>

    /**
     * Searches for photos based on the provided query and optional parameters.
     *
     * @param query The search query for photos.
     * @param orientation Optional orientation filter (e.g., "landscape", "portrait").
     * @param size Optional size filter (e.g., "small", "medium", "large").
     * @param color Optional color filter.
     * @param locale Optional locale filter for the search results.
     * @param page The page number to retrieve.
     * @param perPage The number of photos per page.
     * @return A [Response] containing [PexelsResponse] with the list of search results.
     */
    @GET("v1/search")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("orientation") orientation: String? = null,
        @Query("size") size: String? = null,
        @Query("color") color: String? = null,
        @Query("locale") locale: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 15
    ): Response<PexelsResponse>

    /**
     * Retrieves featured photo collections from the Pexels API.
     *
     * @param page The page number to retrieve.
     * @param perPage The number of collections per page.
     * @return A [Response] containing [CollectionsResponse] with the list of featured collections.
     */
    @GET("v1/collections/featured")
    suspend fun getFeaturedCollections(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 15
    ): Response<CollectionsResponse>

    /**
     * Retrieves photos from a specific collection by its ID.
     *
     * @param collectionId The ID of the collection.
     * @param type Optional type filter (e.g., "photos" or "videos").
     * @param sort Optional sort order (e.g., "asc" or "desc").
     * @param page The page number to retrieve.
     * @param perPage The number of items per page.
     * @return A [Response] containing [CollectionMediaResponse] with the list of photos or media from the collection.
     */
    @GET("v1/collections/{id}")
    suspend fun getCollectionPhotos(
        @Path("id") collectionId: String,
        @Query("type") type: String? = null,
        @Query("sort") sort: String? =null,
        @Query("page") page: Int ,
        @Query("per_page") perPage: Int
    ): Response<CollectionMediaResponse>

    /**
     * Retrieves a specific photo by its ID.
     *
     * @param id The ID of the photo.
     * @return A [Response] containing [Photo] with the details of the specified photo.
     */
    @GET("v1/photos/{id}")
    suspend fun getPhotoById(
        @Path("id") id: Long
    ): Response<Photo>
}
