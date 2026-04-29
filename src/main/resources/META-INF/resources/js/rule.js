document.getElementById("submitRuleBtn").addEventListener("click", async function () {
    const ruleName = document.getElementById("ruleName").value.trim();
    const ruleDescription = document.getElementById("ruleDescription").value.trim();

    if (!ruleName || !ruleDescription) {
        alert("Please fill out both fields.");
        return;
    }

    const ruleData = {
        name: ruleName,
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
            const msg = document.getElementById("formMessage");
            msg.textContent = "Rule created successfully!";
            msg.classList.remove("d-none");
            document.getElementById("newRuleForm").reset();
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

modalEl.addEventListener("hidden.bs.modal", function () {
    const msg = document.getElementById("formMessage");
    msg.classList.add("d-none");
    msg.textContent = "";
});

