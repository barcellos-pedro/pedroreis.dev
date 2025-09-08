@import static com.pedroreis.dev.utils.Template.join
@import static com.pedroreis.dev.utils.Template.date

@import com.pedroreis.dev.model.Repo

@param Repo repo

<div class="repo-header">
    <a href="${repo.htmlUrl()}" target="_blank">
        <p>${repo.name()}</p>
    </a>

    <small>
        <time datetime="${date(repo.createdAt())}">
            ${date(repo.createdAt())}
        </time>
    </small>
</div>

@if (!repo.topics().isEmpty())
    <small style="display: block">
        Topics: ${join(repo.topics())}
    </small>
@endif

<p>${repo.description()}</p>
