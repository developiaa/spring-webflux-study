package study.developia.completablefuture.blocking;

import lombok.RequiredArgsConstructor;
import study.developia.completablefuture.blocking.repository.ArticleRepository;
import study.developia.completablefuture.blocking.repository.FollowRepository;
import study.developia.completablefuture.blocking.repository.ImageRepository;
import study.developia.completablefuture.blocking.repository.UserRepository;
import study.developia.completablefuture.common.Article;
import study.developia.completablefuture.common.Image;
import study.developia.completablefuture.common.User;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserBlockingService {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final ImageRepository imageRepository;
    private final FollowRepository followRepository;

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id)
                .map(user -> {
                    var image = imageRepository.findById(user.getProfileImageId())
                            .map(imageEntity -> {
                                return new Image(imageEntity.getId(), imageEntity.getName(), imageEntity.getUrl());
                            });

                    var articles = articleRepository.findAllByUserId(user.getId())
                            .stream().map(articleEntity ->
                                    new Article(articleEntity.getId(), articleEntity.getTitle(), articleEntity.getContent()))
                            .collect(Collectors.toList());

                    var followCount = followRepository.countByUserId(user.getId());

                    return new User(
                            user.getId(),
                            user.getName(),
                            user.getAge(),
                            image,
                            articles,
                            followCount
                    );
                });
    }
}
