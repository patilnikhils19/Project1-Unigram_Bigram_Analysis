Project 1
Unigram Bigram Analysis


An N-gram is a contiguous sequence of N items from a given sequence of text or speech. An N-gram model is a
type of probabilistic language model for predicting the next item in such a sequence in the form of a (n-1). Ngram
models are widely used in statistical natural language processing. In speech recognition, phonemes and
sequence of phonemes are modeled using a N-gram distribution. For sequences of words, the 1-grams (aka
unigram) generated from “We analyze large dataset” are (“We”, “analyze”, “large”, “dataset”). For the same
sentence, the 2-grams (aka bigram) are (“__ , We”, “We, analyze”, “analyze, large”, “large, dataset”, “dataset,
__”). Here, “__” represents the empty space before and after the sentence.

N-grams are used for various applications such as approximate matching, plagiarism detection, searching for
the similar documents, automatic authorship detection, and linguistic cultural trend analysis. Google’s Ngram
Viewer is a good example of N-gram analysis1.
(https://books.google.com/ngrams/info)
In this assignment, you will create N-gram profile of the corpus of modern English literature. In this assignment,
you will (1) extract all the unigram, and bigram, (2) compute the frequency of each unigram and bigram, and (3)
rank the unigram and bigram based on these frequencies.

Generating N gram profile

In this project, you should generate unigram profiles and bigram profiles. To extract unigram, you should
tokenize the sentences based on the whitespace characters. For the words that span sentence boundaries
should be omitted. Add sentence beginning (“_START_”) and end tokens (“_END_”) for bigrams. This allows
you to distinguish Ngrams that appear in sentence-medial positions from unigrams that occur at sentence
boundaries later on. Ignore tense, gender, and hyphened words. “He” and “She” should be considered as the
different words. “have” and “has”, or “have” and “had” should be considered as the different words. “welldescribed”
should be considered as 1 unigram. Please ignore lower, upper cases. Convert all of the upper cases
to lower case for your convenience.

Your Ngrams should ignore any punctuations or apostrophes. Consider “you’re” as a unigram. In your output,
“you’re” should be listed as “youre”. The frequency of Ngram should count only the exact same appearance of
text. Do not eliminate the stop words.
Your corpus will be a set of modern English literatures. Your Ngram profile should generate,

(1) Profile 1-A
A list of unigrams sorted by unigrams in an alphabetical ascending order. Within the same unigram, the list
should be sorted by year in an ascending order.

(2) Profile 1-B
A list of unigrams sorted by unigrams in an alphabetical ascending order. Within the same unigram, the list
should be sorted by author’s last name in an ascending order.

(3) Profile 2-A
A list of bigrams sorted by bigrams in an alphabetical ascending order. Within the same bigram, the list
should be sorted by year in an ascending order.

(4) Profile 2-B
A list of bigrams sorted by bigrams in an alphabetical ascending order. Within the same bigram, the list
should be sorted by author in an ascending order.
The result of your computation should be stored as file(s). You should generate the result using Hadoop’s
MapReduce programing framework.
