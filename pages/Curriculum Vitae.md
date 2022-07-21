public:: true
alias:: CV

- CV TODOs
  collapsed:: true
	- TODO Figure out ways to filter the contents of job entries (e.g., get rid of `type` field)
	- TODO figure out sort, including grouping by parent
- **Professional Profile:** A heck of a guy with extensive experience in research, leadership, and data.
- query-table:: false
  #+BEGIN_QUERY
  {
  :title [:h2 "Work Experience"]
  :query [
      :find (pull ?b [*])
      :where 
          (property ?b :type "job")
          [?b :block/parent ?parent]
          ; (!= ?parent "Templates")
  ]
  ; For some reason, this doesn't sort
  ; can use (map) to confirm we're extracting the right information
  ; :result-transform
  ;    (fn [result]
  ;          (sort-by (fn [h]
  ;                               (-> (:block/properties h)
  ;                                     (:end-date)
  ;                          ))
  ;                                 result))
  }
  #+END_QUERY
- Academic Training
	- [[UC Berkeley Ph.D. in Psychology]]
	- [[MIT Master's in Brain and Cognitive Science]]
	- [[University of Maryland Bachelor's in Math, Computer Science, and Linguistics]]
- Publications, Data, and Code
	- [Google Scholar](https://scholar.google.com/citations?user=M2sw2kwAAAAJ)
	- [ORCID](https://orcid.org/my-orcid?orcid=0000-0002-3982-4416)
	- [GitHub](https://github.com/davclark)