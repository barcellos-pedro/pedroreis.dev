@import static com.pedroreis.dev.utils.Templates.join
@import static com.pedroreis.dev.utils.Templates.date

@import com.pedroreis.dev.model.Repo

@param Repo repo

<div class="repo-header">
    <p>${repo.name()}</p>

    <smal>
        <time datetime="${date(repo.createdAt())}">
            ${date(repo.createdAt())}
        </time>
    </small>
</div>

<small style="display: block">
    Topics: ${join(repo.topics())}
</small>

<a href="${repo.htmlUrl()}" target="_blank">
    Github page
</a>

<p>${repo.description()}</p>
