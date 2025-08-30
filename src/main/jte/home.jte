@param String avatarUrl
@param String visits
@param String userName

@template.layout(
title = "Home | Bio",
content = @`
    <div style="display: flex; flex-direction: column; align-items: center; justify-content:center; height: 100vh;">
        <img src="${avatarUrl}" style="width:112px; height:112px; border-radius: 50%" alt="user profile image">

        <p style="margin-top: 2em; font-weight: bold; margin-bottom: 0.5em">
            Pedro Barcellos dos Reis
        </p>
        <p style="margin-top: 0; font-weight: 300">
            Software Engineer
        </p>

        <a href="#">Check out my Portfolio stats!
            <svg width="16" height="10" viewBox="0 0 16 10" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M15.4419 5.44194C15.686 5.19786 15.686 4.80213 15.4419 4.55806L11.4645 0.580581C11.2204 0.336504 10.8247 0.336504 10.5806 0.580582C10.3365 0.824659 10.3365 1.22039 10.5806 1.46447L14.1161 5L10.5806 8.53553C10.3365 8.77961 10.3365 9.17534 10.5806 9.41942C10.8247 9.66349 11.2204 9.66349 11.4645 9.41942L15.4419 5.44194ZM4.82111e-08 5.625L15 5.625L15 4.375L-4.82111e-08 4.375L4.82111e-08 5.625Z"
                      fill="currentColor"></path>
            </svg>
        </a>

        <section id="links" style="display:flex; gap:3em; align-items:center">
            <a href="https://github.com/barcellos-pedro" target="_blank" title="Github">
                <img src="https://media.bio.site/public/library/icons-catalog/links/other/github.png"
                     alt="github octocat logo"
                     width="45px"
                     height="45px">
            </a>
            <a href="mailto:pedrobarcellosdosreis@gmail.com" target="_blank" title="E-mail" style="padding: 1em">
                <svg width="18" height="14"
                     viewBox="0.2626950144767761,0.21000000834465027,17.30840492248535,14.0447998046875"
                     xmlns="http://www.w3.org/2000/svg">
                    <path d="M15.1293 0.210C16.4203 0.2104 17.552 1.2557 17.5687 2.5437C17.5688 2.5508 17.5698 2.5579 17.5698 2.565C17.5698 2.5682 17.5711 2.5722 17.5711 2.5753V11.827C17.5711 13.117 16.4343 14.2544 15.1293 14.2548H2.7051C1.3994 14.2548 0.262695 13.118 0.262695 11.827V2.5605C0.2628 2.5553 0.2639 2.5502 0.2641 2.545C0.2808 1.256 1.4135 0.210 2.7051 0.210H15.1293ZM2.0693 11.827C2.0693 12.1742 2.3573 12.4622 2.7051 12.4622H15.1293C15.4762 12.4619 15.7632 12.1739 15.7632 11.827V4.1475L9.4336 8.6438C9.1606 8.8378 8.8394 8.8378 8.5664 8.6438L2.2378 4.1463V11.827ZM2.7051 1.8578C2.4556 1.8578 2.2435 1.9932 2.1208 2.2142L8.9609 6.9695L15.7984 2.2142C15.676 1.9938 15.464 1.858 15.1293 1.8578H2.7051Z"
                          fill="currentColor"></path>
                </svg>
            </a>
            <a href="https://linkedin.com/in/pedro-barcellos" target="_blank" title="LinkedIn" style="padding: 1em">
                <svg height="20" width="20" viewBox="4,3.9999992847442627,12,12.000000953674316"
                     xmlns="http://www.w3.org/2000/svg">
                    <path d="M5.47499 4.00042C5.28299 3.99577 5.09199 4.02969 4.91325 4.10017C4.73451 4.17065 4.57163 4.27626 4.4342 4.41081C4.29676 4.54535 4.18755 4.70611 4.11298 4.88361C4.03841 5.06111 4 5.25178 4 5.44439C4 5.637 4.03841 5.82766 4.11298 6.00517C4.18755 6.18267 4.29676 6.34342 4.4342 6.47796C4.57163 6.61251 4.73451 6.71813 4.91325 6.78861C5.09199 6.85908 5.28299 6.893 5.47499 6.88835C5.85085 6.87926 6.20826 6.72314 6.47088 6.45333C6.7335 6.18353 6.88051 5.82143 6.88051 5.44439C6.88051 5.06734 6.7335 4.70525 6.47088 4.43544C6.20826 4.16564 5.85085 4.00951 5.47499 4.00042ZM13.0407 7.83363C11.8401 7.83363 11.0416 8.49323 10.7115 9.12005H10.6587V8.01765H8.30188V16H10.7635V12.0609C10.7635 11.0207 10.9696 10.0132 12.2557 10.0132C13.5225 10.0132 13.5392 11.1879 13.5392 12.1139V16H16V11.6147C16 9.46875 15.5442 7.83363 13.0407 7.83363ZM4.27017 8.01765V16H6.75773V8.01765H4.27017Z"
                          fill="currentColor"></path>
                </svg>
            </a>
        </section>
    </div>
`)
