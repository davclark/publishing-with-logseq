Publishing with Logseq
----------------------

Currently, this is a minimal example to explore Logseqs querying functionality so that I can develop
things like a CV and a microblog. I created a [post on the Logseq forum for
discussion](https://discuss.logseq.com/t/9079).

## Getting started

1. Load this graph into your local Logseq app to get it initialized in the `~/.logseq/graphs` dir
2. Install npm via your favorite method (I like asdf)
3. `npm install`
4. npx nbb-logseq query.cljs publishing-with-logseq <something>

Provided examples in the nbb-logseq repo work trivially:

- `npx nbb-logseq query.cljs publishing-with-logseq '[:find (pull ?b [*]) :where [?b :block/marker]]'`
- `npx nbb-logseq query.cljs publishing-with-logseq '[:find ?n :where [?b :block/name ?n]]'`

This was a bit more work, and you can see how I'm now importing logseq.db for rules in nbb.edn and
importing and using them in query.cljs:

- `npx nbb-logseq query.cljs publishing-with-logseq '[:find (pull ?b [*]) :where (property ?b :type "job")]'`

If you want to use soemthing like a property query without the nbb.edn, etc. you can just not use
logseq's custom rules, e.g.:

- `npx nbb-logseq query.cljs publishing-with-logseq '[:find (pull ?b [*]) :where [?b :block/properties ?prop] [(get ?prop :type) ?type] [(= ?type "job")]]'`
