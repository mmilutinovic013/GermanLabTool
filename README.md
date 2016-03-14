# GermanLabTool
This tool is intended to help improve grammatical and other linguistical analysis. This software uses a few open source external 
technologies. These technologies will be listed below. This README file is a work in progress and will have proper licensing once components
are added. Technologies include: 

-GUM
-XRenner
-The Stanford Parser


Demonstrate a stanford parser output to be used by XRenner:   ./lexparser.sh data/testsent.txt

[main] INFO edu.stanford.nlp.parser.lexparser.LexicalizedParser - Loading parser from serialized file edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz ... 
 done [0.8 sec].
Parsing file: data/testsent.txt
Parsing [sent. 1 len. 21]: Scores of properties are under extreme fire threat as a huge blaze continues to advance through Sydney 's north-western suburbs .
(ROOT
  (S
    (NP
      (NP (NNS Scores))
      (PP (IN of)
        (NP (NNS properties))))
    (VP (VBP are)
      (PP (IN under)
        (NP (JJ extreme) (NN fire) (NN threat)))
      (SBAR (IN as)
        (S
          (NP (DT a) (JJ huge) (NN blaze))
          (VP (VBZ continues)
            (S
              (VP (TO to)
                (VP (VB advance)
                  (PP (IN through)
                    (NP
                      (NP (NNP Sydney) (POS 's))
                      (JJ north-western) (NNS suburbs))))))))))
    (. .)))

nsubj(threat-8, Scores-1)
case(properties-3, of-2)
nmod:of(Scores-1, properties-3)
cop(threat-8, are-4)
case(threat-8, under-5)
amod(threat-8, extreme-6)
compound(threat-8, fire-7)
root(ROOT-0, threat-8)
mark(continues-13, as-9)
det(blaze-12, a-10)
amod(blaze-12, huge-11)
nsubj(continues-13, blaze-12)
nsubj(advance-15, blaze-12)
advcl(threat-8, continues-13)
mark(advance-15, to-14)
xcomp(continues-13, advance-15)
case(suburbs-20, through-16)
nmod:poss(suburbs-20, Sydney-17)
case(Sydney-17, 's-18)
amod(suburbs-20, north-western-19)
nmod:through(advance-15, suburbs-20)

Parsing [sent. 2 len. 16]: Fires have also shut down the major road and rail links between Sydney and Gosford .
(ROOT
  (S
    (NP (NNP Fires))
    (VP (VBP have)
      (ADVP (RB also))
      (VP (VBN shut)
        (PRT (RP down))
        (NP
          (NP (DT the) (JJ major) (NN road)
            (CC and)
            (NN rail) (NNS links))
          (PP (IN between)
            (NP (NNP Sydney)
              (CC and)
              (NNP Gosford))))))
    (. .)))

nsubj(shut-4, Fires-1)
aux(shut-4, have-2)
advmod(shut-4, also-3)
root(ROOT-0, shut-4)
compound:prt(shut-4, down-5)
det(road-8, the-6)
amod(road-8, major-7)
dobj(shut-4, road-8)
cc(road-8, and-9)
compound(links-11, rail-10)
dobj(shut-4, links-11)
conj:and(road-8, links-11)
case(Sydney-13, between-12)
nmod:between(road-8, Sydney-13)
cc(Sydney-13, and-14)
nmod:between(road-8, Gosford-15)
conj:and(Sydney-13, Gosford-15)

Parsing [sent. 3 len. 34]: The promotional stop in Sydney was everything to be expected for a Hollywood blockbuster - phalanxes of photographers , a stretch limo to a hotel across the Quay - but with one difference .
(ROOT
  (S
    (NP
      (NP (DT The) (JJ promotional) (NN stop))
      (PP (IN in)
        (NP (NNP Sydney))))
    (VP (VBD was)
      (NP (NN everything)
        (S
          (VP (TO to)
            (VP (VB be)
              (VP (VBN expected)
                (PP (IN for)
                  (NP
                    (NP (DT a) (NNP Hollywood) (NN blockbuster))
                    (: -)
                    (NP
                      (NP (NNS phalanxes))
                      (PP (IN of)
                        (NP
                          (NP (NNS photographers))
                          (, ,)
                          (NP (DT a) (NN stretch) (NN limo)))))))
                (PP
                  (PP (TO to)
                    (NP
                      (NP (DT a) (NN hotel))
                      (PP (IN across)
                        (NP (DT the) (NNP Quay)))))
                  (: -)
                  (CC but)
                  (PP (IN with)
                    (NP (CD one) (NN difference))))))))))
    (. .)))

det(stop-3, The-1)
amod(stop-3, promotional-2)
nsubj(everything-7, stop-3)
case(Sydney-5, in-4)
nmod:in(stop-3, Sydney-5)
cop(everything-7, was-6)
root(ROOT-0, everything-7)
mark(expected-10, to-8)
auxpass(expected-10, be-9)
acl(everything-7, expected-10)
acl(everything-7, expected-10')
conj:but(expected-10, expected-10')
case(blockbuster-14, for-11)
det(blockbuster-14, a-12)
compound(blockbuster-14, Hollywood-13)
nmod:for(expected-10, blockbuster-14)
dep(blockbuster-14, phalanxes-16)
case(photographers-18, of-17)
nmod:of(phalanxes-16, photographers-18)
det(limo-22, a-20)
compound(limo-22, stretch-21)
appos(photographers-18, limo-22)
case(hotel-25, to-23)
det(hotel-25, a-24)
nmod:to(expected-10, hotel-25)
case(Quay-28, across-26)
det(Quay-28, the-27)
nmod:across(hotel-25, Quay-28)
cc(expected-10, but-30)
case(difference-33, with-31)
nummod(difference-33, one-32)
nmod:with(expected-10', difference-33)

Parsing [sent. 4 len. 13]: A line-up of masseurs was waiting to take the media in hand .
(ROOT
  (S
    (NP
      (NP (DT A) (NN line-up))
      (PP (IN of)
        (NP (NNS masseurs))))
    (VP (VBD was)
      (VP (VBG waiting)
        (S
          (VP (TO to)
            (VP (VB take)
              (NP (DT the) (NNS media))
              (PP (IN in)
                (NP (NN hand))))))))
    (. .)))

det(line-up-2, A-1)
nsubj(waiting-6, line-up-2)
nsubj(take-8, line-up-2)
case(masseurs-4, of-3)
nmod:of(line-up-2, masseurs-4)
aux(waiting-6, was-5)
root(ROOT-0, waiting-6)
mark(take-8, to-7)
xcomp(waiting-6, take-8)
det(media-10, the-9)
dobj(take-8, media-10)
case(hand-12, in-11)
nmod:in(take-8, hand-12)

Parsing [sent. 5 len. 13]: Never has the term `` massaging the media '' seemed so accurate .
(ROOT
  (S
    (NP (NNP Never))
    (VP (VBZ has)
      (NP
        (NP (DT the) (NN term))
        (SBAR
          (S (`` ``)
            (S
              (VP (VBG massaging)
                (NP (DT the) (NNS media))))
            ('' '')
            (VP (VBD seemed)
              (ADJP (RB so) (JJ accurate)))))))
    (. .)))

nsubj(has-2, Never-1)
root(ROOT-0, has-2)
det(term-4, the-3)
dobj(has-2, term-4)
csubj(seemed-10, massaging-6)
det(media-8, the-7)
dobj(massaging-6, media-8)
acl:relcl(term-4, seemed-10)
advmod(accurate-12, so-11)
xcomp(seemed-10, accurate-12)

Parsed file: data/testsent.txt [5 sentences].
Parsed 97 words in 5 sentences (35.48 wds/sec; 1.83 sents/sec).

This data can then be added to other parsing tools to be analyzed further.
