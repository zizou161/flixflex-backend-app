package com.factorydigital.flixflex.userProfile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("api/v1/user-profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final UserProfileMapper userProfileMapper;

    @GetMapping(path = "/add-movie-to-favorites")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "add a movie to favorite list")
    public ResponseEntity<UserProfileDto> addMovieToFavorites(@RequestParam Long movieId) throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(userProfileMapper.toDto(userProfileService.addMovieToFavorites(movieId)));
    }

    @GetMapping(path = "/add-tvShow-to-favorites")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "add a tvShow to favorite list")
    public ResponseEntity<UserProfileDto> addTvShowToFavorites(@RequestParam Long tvShowId) throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(userProfileMapper.toDto(userProfileService.addTvShowToFavorites(tvShowId)));
    }
}