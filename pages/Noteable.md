public:: true

- Senior Backend Engineer
  id:: 629a8246-bf1c-4404-ae40-db5ca56f06a0
  start-date:: [[Wed, 2021/11/10]]
  end-date:: [[Thu, 2022/05/26]]
  type:: job
  collapsed:: true
	- Responsibilities
		- Participated in strategic planning across teams at a series A startup, with a focus on managing state and execution on back-end compute kernels.
		- Independent contribution as well as supporting junior and lateral peers on a complex distributed system.
		- Rotating site reliability engineering (SRE) responsibilities.
	- Achievements
		- Improved scalability and enabled headless compute for jupyter compute kernels.
		- Developed observable, testable async code to manage and publish compute state.
		- Coordinated work across backend and frontend teams for a complex distributed interactive compute product.
		- Continuous improvement of sprint management via Jira and scoping of pull requests.
		- Provided rapid triage, customer feedback, and work planning to address site reliability issues, as well as providing support to the SRE on-call.
		- Assisted both backend and frontend engineers with context and extensive pair programming.
	- Skills used
		- FastAPI and Pydantic
		- CockroachDB
		- Redis
		- Kubernetes (minikube, EKS, kopf)
		- Playwright end-to-end tests
		- Jupyter kernels
		- Jira
- Challenges
	- Fetch policy made local development easily fall out of sync with production / latest
		- This led to mysterious errors that were hard to diagnose
		- Led a multi-person debugging effort and update to dev image pull policy (from IfNotPresent to Always)
			- This unfortunately made off-line development mildly problematic, but in a more obvious way
			- While waiting for this to get approved and merged, was vigilant on Slack to identify the problem when it hit other developers so that they wouldn't lose a day of work, also ensured folks were aware of a (documented) manual fix (locally delete images from the minikube / k8s docker context)
		- Also worked with DevOps to develop proposal to make local dev reliably closer to production
- Ideas (see also backlinks)
	- Partners
		- I'd really like to be more engaged with the [[DOE]] / #energy innovation
		  collapsed:: true
			- [[Derek]] - Los Alamos / DOE
			- [[Katy Huff]], [[Rachel Slaybaugh]], [[Anthony Scopatz]], etc. - DOE
			- [[Nate Bender]] - Exelon / distributed energy
			- Indirectly, [[Robert Gehorsam]] - DOE, Sandia
		- [[Kevin Koy]] - Senior director research & insights at [[IDEO]]
	- Product
		- Stats overlay (like DEX, enabled on tabular output)
			- cf. Jamovi, SPSS, Stata
			- Could take advantage of Doug Bate's work on mixed models in Julia
		- Cells used like blocks in Roam / Logseq / Obsidian / etc.
		- Rmd?
		  collapsed:: true
			- Note that Rmd plays nicer with the zettle-type integration above
		- Generalizing notion of reusable "glass bricks" (vs. "black boxes") as discussed in convo with [[Elijah Meeks]] - starting with how to save facets of a viz for re-use
		- https://github.com/jupyterlab/jupyterlab/issues/9194