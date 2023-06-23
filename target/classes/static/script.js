document.getElementById("create-form").addEventListener("submit", function(event) {
    event.preventDefault();

    var name = document.getElementById("name").value;
    var designation = document.getElementById("designation").value;

    var employee = {
        name: name,
        designation: designation
    };

    fetch("/employees", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
    })
    .then(function(response) {
        if (response.ok) {
            return response.json();
        }
        throw new Error("Error creating employee.");
    })
    .then(function(data) {
        // Handle successful response (e.g., display success message)
        console.log("Employee created:", data);
    })
    .catch(function(error) {
        // Handle error response (e.g., display error message)
        console.error("Error:", error);
    });
});

fetch("/employees")
    .then(function(response) {
        if (response.ok) {
            return response.json();
        }
        throw new Error("Error retrieving employees.");
    })
    .then(function(data) {
        var employeeList = document.getElementById("employee-list");
        data.forEach(function(employee) {
            var listItem = document.createElement("li");
            listItem.textContent = "Name: " + employee.name + ", Designation: " + employee.designation;
            employeeList.appendChild(listItem);
        });
    })
    .catch(function(error) {
        // Handle error response (e.g., display error message)
        console.error("Error:", error);
    });
