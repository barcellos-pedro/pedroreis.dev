@import com.pedroreis.dev.model.Link
@import java.util.List

@param List<Link> links

@template.layout(
title = "Home",
content = @`
    <div class="bio">
        <img src="https://avatars.githubusercontent.com/u/33139500?v=4" alt="Pedro's profile image">

        <h3>
            <p>Pedro Barcellos dos Reis</p>
            <p>Software Engineer</p>
        </h3>

        <a href="/projects">Check out my projects &rarr;</a>

        <section class="links">
            @for (var link : links)
                <a href="${link.url()}" title="${link.title()}" target="_blank">
                    ${link.title()}
                </a>
            @else
                <p>Links are under maintenance</p>
            @endfor
        </section>
    </div>
`)
