/** @format */

var userContainter = document.getElementById("users_container");
var btn_pretrazi = document.getElementById("btn_first_name");
var text = document.getElementById("input_first_name");

function CardAdd(user) {
	return `                    
        <section class="py-5">

                    <div class="row gx-5  justify-content-center">
                        
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="/assets/${
																	user.picture
																}" alt="..." />
                                <h5 class="fw-bolder">${
																	user.firstname + " " + user.lastname
																}</h5>
                                <div class="fst-italic text-muted">${
																	"Godine: " + user.years
																}</div>
																                   
                            </div>
																
                        </div>

                </div>
            </section>`;
}

fetch("http://localhost:8082/users")
	.then((response) => response.json())
	.then((users) => {
		var usersMarkup = "";
		for (let user of users) {
			usersMarkup += CardAdd(user);
		}

		userContainter.innerHTML = usersMarkup;
		btn_pretrazi.addEventListener("click", function (event) {
			var usersMarkup = "";
			for (let user of users) {
				if (user.firstname.toLowerCase().includes(text.value.toLowerCase()))
					usersMarkup += CardAdd(user);
			}
			userContainter.innerHTML = usersMarkup;
		});
	});
document
	.getElementById("submitButton")
	.addEventListener("click", function (event) {
		event.preventDefault();

		const user = {
			jmbg: document.getElementById("jmbg").value,
			firstname: document.getElementById("firstname").value,
			lastname: document.getElementById("lastname").value,
			years: document.getElementById("years").value,
			picture: document.getElementById("picture").value,
		};

		fetch("http://localhost:8082/users", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(user),
		})
			.then((response) => response.json())
			.then((data) => {
				console.log("Success:", data);
				document
					.getElementById("submitSuccessMessage")
					.classList.remove("d-none");
			})
			.catch((error) => {
				console.error("Error:", error);
				document
					.getElementById("submitErrorMessage")
					.classList.remove("d-none");
			});
	});
