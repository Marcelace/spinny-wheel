document.getElementById("submitRuleBtn").addEventListener("click", async function () {
    const ruleName = document.getElementById("ruleName").value.trim();
    const ruleDescription = document.getElementById("ruleDescription").value.trim();

    if (!ruleName || !ruleDescription) {
        alert("Please fill out both fields.");
        return;
    }

    const ruleData = {
        text: ruleName,
        description: ruleDescription
    };

    try {
        const response = await fetch("/rules", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(ruleData)
        });

        if (response.ok) {
            const createdRule = await response.json();
            const msg = document.getElementById("formMessage");
            msg.textContent = "Rule created successfully!";
            msg.classList.remove("d-none");
            document.getElementById("newRuleForm").reset();
            window.segments.push(createdRule);
            addSegment(createdRule)
        } else {
            const errorText = await response.text();
            alert("Failed to submit rule: " + errorText);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("An error occurred while submitting.");
    }
});

const modalEl = document.getElementById("newRuleModal");

modalEl.addEventListener("hidden.bs.modal", function () {
    // reset form
    document.getElementById("newRuleForm").reset();

    // hide message
    const msg = document.getElementById("formMessage");
    msg.classList.add("d-none");
    msg.textContent = "";
});


const deleteModal = document.getElementById("deleteRuleModal");

deleteModal.addEventListener("show.bs.modal", populateDeleteModal);

document.getElementById("deleteRuleBtn").addEventListener("click", async function () {
    const selectedRuleId = Number(
        document.getElementById("ruleSelectDeletion").value
    );

    try {
        const response = await fetch(`/rules/${selectedRuleId}`, {
            method: "DELETE"
        });

        if (response.ok) {
            window.segments = window.segments.filter(
                rule => rule.id !== selectedRuleId
            );
            window.location.reload();
        }
    } catch (error) {
        console.error(error);
    }
});

function populateDeleteModal() {
    const select = document.getElementById("ruleSelectDeletion");

    // Keep the placeholder
    select.innerHTML = `
        <option value="" selected disabled>Choose a rule...</option>
    `;

    window.segments.forEach(rule => {
        const option = document.createElement("option");
        option.textContent = rule.text;
        option.value = rule.id;

        select.appendChild(option);
    });
}