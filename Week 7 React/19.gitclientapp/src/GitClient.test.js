// src/GitClient.test.js
const axios = require("axios"); // ✅ use require instead of import
const GitClient = require("./GitClient").default; // ✅ if exported as default

jest.mock("axios");

describe("Git Client Tests", () => {
  test("should return repository names for techiesyed", async () => {
    const dummyData = [
      { name: "repo1" },
      { name: "repo2" },
      { name: "repo3" },
    ];

    axios.get.mockResolvedValue({ data: dummyData });

    const repos = await GitClient.getRepositories("techiesyed");
    expect(repos).toEqual(["repo1", "repo2", "repo3"]);
  });
});
