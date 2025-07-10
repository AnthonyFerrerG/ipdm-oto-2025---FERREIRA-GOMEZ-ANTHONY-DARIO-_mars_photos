object NetworkModule {
  fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()

  fun provideMarsApiService(retrofit: Retrofit): MarsApiService =
    retrofit.create(MarsApiService::class.java)

  fun provideMarsPhotoRepo(service: MarsApiService): MarsPhotoRepository =
    DefaultMarsPhotoRepository(service)
}
