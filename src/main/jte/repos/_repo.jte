@import static com.pedroreis.dev.utils.Templates.join
@import static com.pedroreis.dev.utils.Templates.date

@import com.pedroreis.dev.model.Repo

@param Repo repo

<div class="repo-header">
    <a href="${repo.htmlUrl()}" target="_blank">
        <p>${repo.name()}</p>
    </a>

    <smal>
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
