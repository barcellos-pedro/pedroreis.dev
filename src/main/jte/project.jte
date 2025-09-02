@import com.pedroreis.dev.Repo
@import static com.pedroreis.dev.Templates.join
@import static com.pedroreis.dev.Templates.date

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
